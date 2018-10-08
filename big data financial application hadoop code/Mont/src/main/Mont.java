package main;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.v2.app.job.event.JobFinishEvent;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;
        




import main.DBOutputWritable;

public class Mont  {
        
 public static class Map extends Mapper<DoubleWritable, DoubleWritable,IntWritable, DoubleWritable > {
    private final static IntWritable one = new IntWritable(1);
    private DoubleWritable predictedPrice = new DoubleWritable(0.0);
    private Text word = new Text();
        
    public void map(DoubleWritable key, DoubleWritable value, Context context) throws IOException, InterruptedException {
        Double pPrice  = 0.0;
        //System.out.println("mapper *");
       // System.out.println("Key "+key.get()+" Value : "+value.get());
        NormInv norm = new NormInv();
        Random rand = new Random(); 
        
        Double randomNumber = rand.nextDouble();
        pPrice = (Double)key.get() * (Double)( 1+norm.compute(randomNumber,0, (Double)(value.get()/100)));
        context.write(new IntWritable(1), new DoubleWritable(pPrice));
        double nextPrice = 0.0;
        
        /*DecimalFormat df = new DecimalFormat("#####.##########");
        df.setRoundingMode(RoundingMode.CEILING);
        */
        for (int i = 1; i<=21 ; i++)
        {
        	nextPrice = pPrice * ((Double)( 1+norm.compute(randomNumber,0, (Double)(value.get()/100))));
        	context.write(new IntWritable(i+1), new DoubleWritable(nextPrice));
        	
        	pPrice = nextPrice;
        }
        
        
        
        
      	//context.write(new DoubleWritable(Double.valueOf(df.format((pPrice)))), one);
        
        
        //System.out.println(pPrice);
        //context.write(one, new DoubleWritable(pPrice));
        
    	/*String line = value.toString();
        System.out.println("mapper *");
        //StringTokenizer tokenizer = new StringTokenizer(line);
        StringTokenizer tokenizer = new StringTokenizer(line,",");
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            context.write(word, one);
        }*/
    }
 } 
        
 public static class Reduce extends Reducer<IntWritable,DoubleWritable,  DBOutputWritable, NullWritable> {

    public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context) 
      throws IOException, InterruptedException {
        int sum = 0;
        int total = 0;
        int finalSum = 0;
        double finalKey = 0;
        //System.out.println("reducer *");
        
        
        DescriptiveStatistics stats = new DescriptiveStatistics();
       
        
        for (DoubleWritable val : values) {
        	//total++;
           // sum += val.get();
            stats.addValue(val.get());
            //System.out.println("RedVal:" + val.get());
            
        }
        
        double f_per = 5.00;
        double t_per = 25.00;
        double s_per = 75.00;
        double n_per = 95.00;
        
        
        double fpercentile = stats.getPercentile(f_per);
        double tpercentile = stats.getPercentile(t_per);
        double spercentile = stats.getPercentile(s_per);
        double npercentile = stats.getPercentile(n_per);
        
       
       // IntWritable i = new Int
        
        /*context.write(key, new DoubleWritable(fpercentile));
        context.write(key, new DoubleWritable(tpercentile));
        context.write(key, new DoubleWritable(spercentile));
        context.write(key, new DoubleWritable(npercentile));
        */
        
        String company_name= "Proctor and Gamble";
        String stock_name = "PG";
        
        
        try
        {
        	context.write(new DBOutputWritable(company_name, stock_name, key.get(), fpercentile, tpercentile, 
                	spercentile, npercentile), NullWritable.get());
        } catch(IOException e)
        {
          e.printStackTrace();
        } catch(InterruptedException e)
        {
          e.printStackTrace();
        }		
        
        
    }
 }
        
 public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
        //JobConf job = new JobConf(new Configuration(),WordCount.class);
    DBConfiguration.configureDB(conf,
    	     "com.mysql.jdbc.Driver",   // driver class
    	     "jdbc:mysql://localhost:3306/monte_carlo", // db url
    	     "root",    // username
    	     "cloudera"); //password
        Job job = new Job(conf, "mont");
    
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(DoubleWritable.class);
	    job.setOutputKeyClass(DBOutputWritable.class);
	    job.setOutputValueClass(NullWritable.class);
	    
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
    job.setInputFormatClass(SequenceFileInputFormat.class);
    //job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(DBOutputFormat.class);
    /*DBInputFormat.setInput(job,
   	     new ,    // output table name
   	     new String[] {"ID", "CNAME", "SNAME", "DAY", "P5" , "P25" , "P75" , "P95" });
    */DBOutputFormat.setOutput(
    	     job,
    	     "prediction_data",    // output table name
    	     new String[] {"CNAME", "SNAME", "DAY", "P5" , "P25" , "P75" , "P95" }   //table columns
    	     );
        
    FileInputFormat.addInputPath(job, new Path("/home/cloudera/Desktop/Mont/input"));
    //FileOutputFormat.setOutputPath(job, new Path("/home/cloudera/Desktop/Mont/output"+ System.currentTimeMillis()));
    final FileSystem fs = FileSystem.get(conf);
    Double stockPrice = 56.1177;
    Double dailySD = 1.730263; 
    int numMaps = 500;
        //generate an input file for each map task
        for(int i=0; i < numMaps; i++) {
          final Path file = new Path("/home/cloudera/Desktop/Mont/input", "part"+i);
          final SequenceFile.Writer writer = SequenceFile.createWriter(
              fs, conf, file,
              DoubleWritable.class,DoubleWritable.class, CompressionType.NONE);
          try {
            writer.append(new DoubleWritable(stockPrice),new DoubleWritable(dailySD));
          } finally {
            writer.close();
          }
         // System.out.println("Wrote input for Map #"+i);
        }
        
    
      //start a map/reduce job
        System.out.println("Starting Job");
        final long startTime = System.currentTimeMillis();
        job.waitForCompletion(true);
        final double duration = (System.currentTimeMillis() - startTime)/1000.0;
        System.out.println("Job Finished in " + duration + " seconds");
        
        
 }
        
}
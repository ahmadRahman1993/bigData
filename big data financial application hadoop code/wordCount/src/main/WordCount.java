package main;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.v2.app.job.event.JobFinishEvent;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
        
public class WordCount {
        
 public static class Map extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {
    private final static IntWritable one = new IntWritable(1);
    //private Text word = new Text();
    //private  int num = 1;
        
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        //System.out.println("mapper *");
     
        Double yesterday=0.0,today=0.0,dailySD=0.0;
        String[] columns = line.split(",");
        
        yesterday = Double.valueOf(columns[5]);
        today = Double.valueOf(columns[7]);
        
        dailySD = (Double)(((yesterday - today)/yesterday)*100) ;
        System.out.println(dailySD);
        context.write(one,new DoubleWritable(dailySD));
    }
 } 
        
 public static class Reduce extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

    public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context) 
      throws IOException, InterruptedException {
      
        System.out.println("reducer *");   
        DescriptiveStatistics stats = new DescriptiveStatistics();
        
        for (DoubleWritable val : values) {
             stats.addValue(val.get());   
        }
        
        double std = stats.getStandardDeviation();
        context.write(key, new DoubleWritable(std));
    }
 }
        
 public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
        //JobConf job = new JobConf(new Configuration(),WordCount.class);
        Job job = new Job(conf, "wordcount");
    job.setOutputKeyClass(IntWritable.class);
    job.setOutputValueClass(DoubleWritable.class);
        
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
        
    FileInputFormat.addInputPath(job, new Path("/home/cloudera/Desktop/appl2.csv"));
    FileOutputFormat.setOutputPath(job, new Path("/home/cloudera/Desktop/sd/output" + System.currentTimeMillis()));
        
    job.waitForCompletion(true);
 }
        
}
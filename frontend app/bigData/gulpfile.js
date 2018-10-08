var gulp = require('gulp'),
    uglify = require('gulp-uglify');
console.log('start');
gulp.task('default', function () {
    console.log('in default task');
    gulp.src('app/*.js').pipe(uglify()).pipe(gulp.dest('build/min.js'));
});

gulp.task('script', function () {
    console.log('in script tasks');
    gulp.src('app/*.css').pipe(uglify()).pipe(gulp.dest('build/min.css'));
});
console.log('end');
gulp.task('default',['script']);
# Squish Coco Emma plugin

This plugin allows you to capture EMMA-XML reports generated by [Squish Coco](https://www.froglogic.com/coco/) and display code coverage statistics.
This plugin is not limited to Squish Coco but support any report in [EMMA](http://emma.sourceforge.net/) format. 

It displays the coverage statistics for several metrics (function, line,
statement block, decision, condition, MC/DC and MCC) at for the source
files, the classes and the functions of the covered code.

For each metric, it is possible to define a target threshold and the coverage
statistics can be graphically followed through a time graph.

## Usage

### General configuration
The plugin provides the post-build __Record Squish Coco Emma Coverage Report__ action. The action allows configuring paths to the EMMA-xml report files.  
The path is relative to the workspace root of the Jenkins job.

Once the path is configured and points to the generated EMMA XML file, a user can define health report thresholds.

### Squish Coco configuration

As first step, it is necessary to add a post-build rule to create an EMMA report from the _.csmes_ file. For this, _cmreport_ can be used as followings:

```
$ cmreport -m testsuite.csmes --emma=testsuite.xml
```

The file _testsuite.xml_ can then be used as input for the post-build __Record Squish Coco Emma Coverage Report__.


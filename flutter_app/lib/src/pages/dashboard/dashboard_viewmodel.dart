import 'package:charts_flutter/flutter.dart' as charts;
import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/models/subscriber_series.dart';

class DashboardViewModel {
  
  final List<SubscriberSeries> timeSeries = [
    SubscriberSeries(
      year: "2008",
      subscribers: 10000000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2009",
      subscribers: 11000000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2010",
      subscribers: 12000000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2011",
      subscribers: 10000000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2012",
      subscribers: 8500000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2013",
      subscribers: 7700000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2014",
      subscribers: 7600000,
      barColor: charts.ColorUtil.fromDartColor(Colors.blue),
    ),
    SubscriberSeries(
      year: "2015",
      subscribers: 5500000,
      barColor: charts.ColorUtil.fromDartColor(Colors.red),
    ),
  ];
}

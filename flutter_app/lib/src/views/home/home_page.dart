import 'package:charts_flutter/flutter.dart' as charts;
import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/views/chats/subscriber_chart.dart';
import 'package:smart_energy_app/src/models/subscriber_series.dart';
import 'package:smart_energy_app/src/views/home/home_viewmodel.dart';

class HomePage extends StatelessWidget {
  HomePage({Key? key}) : super(key: key);

  final viewModel = HomeViewModel();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.red,
        title: const Text("Smart Energy"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: SingleChildScrollView(
          child: Column(
            children: [
              SubscriberChart(
                data: viewModel.timeSeries,
              ),
              SubscriberChart(
                data: viewModel.timeSeries,
              )
            ],
          ),
        ),
      ),
    );
  }
}

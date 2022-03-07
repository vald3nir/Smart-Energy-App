import 'package:flutter/material.dart';
import 'package:smart_energy_app/src/components/gauge_chart.dart';

import 'chats/gauge_pie_chart.dart';
import 'chats/subscriber_chart.dart';
import 'daily_consumption/daily_consumption_page.dart';
import 'dashboard_viewmodel.dart';

class DashboardPage extends StatelessWidget {
  DashboardPage({Key? key}) : super(key: key);

  final viewModel = DashboardViewModel();

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
              GaugeChart2.withSampleData(),
              DailyConsumptionPage(),
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

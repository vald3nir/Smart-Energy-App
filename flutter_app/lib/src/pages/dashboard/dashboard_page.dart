import 'package:flutter/material.dart';

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

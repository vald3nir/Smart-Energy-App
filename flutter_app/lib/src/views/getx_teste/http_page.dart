import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:smart_energy_app/src/models/time_series_model.dart';
import 'package:smart_energy_app/src/views/getx_teste/http_controller.dart';

class HttpPage extends GetView<HttpController> {
  const HttpPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("HTTP"),
      ),
      body: controller.obx((state) {
        return ListView.builder(
            itemCount: state.length,
            itemBuilder: (context, index) {
              final TimeSeriesModel item = state[index];
              return ListTile(
                title: Text(index.toString() + " - " + item.date),
                subtitle: Text(item.consumptionKwh.toString()),
              );
            });
      }, onError: (error) {
        return Center(child: Text(error ?? "error"));
      }),
    );
  }
}

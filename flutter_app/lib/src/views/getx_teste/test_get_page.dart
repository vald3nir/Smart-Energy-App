import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:smart_energy_app/src/views/getx_teste/http_bindings.dart';

import 'get_home_page.dart';
import 'http_page.dart';

class TestGetPage extends StatelessWidget {
  const TestGetPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'TestGetPage',
      getPages: [
        GetPage(name: "/", page: () => const GetHomePage(), children: [
          GetPage(
              name: "/http",
              page: () => const HttpPage(),
              binding: HttpBindings())
        ])
      ],
    );
  }
}

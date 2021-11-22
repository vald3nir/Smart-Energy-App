import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:smart_energy_app/src/views/getx_teste/http_bindings.dart';

import 'src/views/dashboard/dashboard_page.dart';
import 'src/views/getx_teste/http_page.dart';
import 'src/views/login/login_page.dart';

void main() {
  runApp(const AppWidget());
}

class AppWidget extends StatelessWidget {
  const AppWidget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      getPages: [
        GetPage(name: "/", page: () => LoginPage(), children: [
          GetPage(
              name: "/dashboard",
              page: () => DashboardPage(),
              binding: HttpBindings()),
          GetPage(
              name: "/http",
              page: () => const HttpPage(),
              binding: HttpBindings())
        ])
      ],
    );
  }
}

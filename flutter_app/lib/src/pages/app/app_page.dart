import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:smart_energy_app/src/pages/dashboard/dashboard_page.dart';
import 'package:smart_energy_app/src/pages/login/login_page.dart';

class AppPage extends StatelessWidget {
  const AppPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {    
    
    var dashboardPage = GetPage(
      name: "/dashboard",
      page: () => DashboardPage(),
      //binding: HttpBindings()
    );

    var homePage = GetPage(
        name: "/", page: () => const LoginPage(), children: [dashboardPage]);

    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      getPages: [homePage],
    );
  }
}

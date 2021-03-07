import 'package:flutter/material.dart';
import 'package:steyrer_app/news.dart';
import 'package:steyrer_app/settings.dart';
import 'package:steyrer_app/themes/color.dart';

void main() {
  runApp(AppRoot());
}

class AppRoot extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Weingut Steyrer',
      theme: SteyrerTheme.defaultTheme,
      home: HomePage()
    );
  }
}

class HomePage extends StatefulWidget {
  
  HomePage({Key key}) : super(key: key);
  
  @override
  State<StatefulWidget> createState() {
    return _MyHomePageState();
  }
  
}

class _MyHomePageState extends State<HomePage> {

  int _selectedIndex = 0;
  
  static List<Widget> _pages = <Widget> [
    NewsWidget(),
    SettingsWidget()
  ];
  
  void _onTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
   return Scaffold(
      appBar: AppBar(
        title: Text("Weingut Steyrer")
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
            label: 'Neuigkeiten',
            icon: Icon(Icons.history),
          ),
          BottomNavigationBarItem(
            label: 'Einstellungen',
            icon: Icon(Icons.settings),
          ),
        ],
       backgroundColor: Color(0xFF376322),
        onTap: _onTapped,
      ),
     body: Center(
       child: _pages.elementAt(_selectedIndex),
     ),
   );
  }

//TODO: Color palette https://material.io/resources/color/#!/?view.left=1&view.right=0&primary.color=376322&secondary.color=CDDC39

}



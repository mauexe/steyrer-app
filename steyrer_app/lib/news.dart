import 'package:flutter/material.dart';

class NewsWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _NewsWidgetState();
  }
}

class _NewsWidgetState extends State<NewsWidget> {
  @override
  Widget build(BuildContext context) {
    return Text("News");
  }

}
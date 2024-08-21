import 'package:flutter/material.dart';

class HelpPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Help'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: ListView(
          children: <Widget>[
            Text(
              'Here are some tips to help you use the app:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            BulletPoint(
              text: 'Navigate through the app using the bottom navigation bar.',
            ),
            BulletPoint(
              text: 'Use the "+" button to add new items to your list.',
            ),
            BulletPoint(
              text: 'Swipe left or right on items to reveal more actions.',
            ),
            BulletPoint(
              text: 'Tap on an item to view detailed information.',
            ),
            BulletPoint(
              text: 'Use the settings menu to customize your experience.',
            ),
            SizedBox(height: 20),
            Text(
              'If you have any questions, feel free to contact support.',
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}

class BulletPoint extends StatelessWidget {
  final String text;

  const BulletPoint({required this.text});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 4.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Text(
            '\u2022', // Unicode for bullet point
            style: TextStyle(fontSize: 20),
          ),
          SizedBox(width: 5),
          Expanded(
            child: Text(
              text,
              style: TextStyle(fontSize: 16),
            ),
          ),
        ],
      ),
    );
  }
}

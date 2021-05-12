import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(

      home: Notification(),
    );
  }
}

class Notification extends StatefulWidget {
  const Notification({Key key}) : super(key: key);

  @override
  _NotificationState createState() => _NotificationState();
}

class _NotificationState extends State<Notification> {

  FlutterLocalNotificationsPlugin localNotification;

  @override
  void initState(){
    super.initState();
    var androidInitialize = new AndroidInitializationSettings('@mipmap/ic_launcher');
    var iOSInitialize = new IOSInitializationSettings();
    var initializeSettings = new InitializationSettings(android: androidInitialize, iOS: iOSInitialize);
    localNotification = new FlutterLocalNotificationsPlugin();
    localNotification.initialize(initializeSettings);

    Future _showNotification() async {
      var androidDetails = new AndroidNotificationDetails("channelId", "Local notification", "Salut mon petit pote", importance: Importance.high);
      var iosDetails = new IOSNotificationDetails();
      var generalNotificationDetails = new NotificationDetails(android: androidDetails, iOS: iosDetails);
      
      await localNotification.show(0, "Notif title", "Notif body", generalNotificationDetails);
    }
  }

  void _showNotification() {}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("Clic ici pour recevoir une notif"),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.notifications),
        onPressed: _showNotification,
      ),
    );
  }
}

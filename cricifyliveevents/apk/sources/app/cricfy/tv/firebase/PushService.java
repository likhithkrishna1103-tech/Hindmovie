package app.cricfy.tv.firebase;

import a7.a;
import ab.g;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import app.cricfy.tv.activities.PlayerActivity;
import app.cricfy.tv.activities.SplashActivity;
import com.bumptech.glide.b;
import com.bumptech.glide.n;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import h0.k;
import h0.l;
import h0.m;
import j9.p;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k4.d;
import nc.o;
import q5.j;
import s7.f;
import v.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class PushService extends FirebaseMessagingService {
    public static final ExecutorService C = Executors.newSingleThreadExecutor();

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(o oVar) {
        Intent intent;
        m mVar;
        a aVar;
        if (oVar.f9067w == null) {
            Bundle bundle = oVar.f9066v;
            e eVar = new e(0);
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        eVar.put(str, str2);
                    }
                }
            }
            oVar.f9067w = eVar;
        }
        e eVar2 = oVar.f9067w;
        String str3 = "no";
        try {
            String str4 = (String) eVar2.get("activity");
            if ("Player".equals(str4)) {
                intent = new Intent(this, (Class<?>) PlayerActivity.class);
                String str5 = (String) eVar2.get("path");
                if (TextUtils.isEmpty(str5)) {
                    str5 = "pro";
                }
                intent.putExtra("links", str5);
                intent.putExtra("fromSplash", false);
            } else if ("openUrl".equals(str4)) {
                String str6 = (String) eVar2.get("url");
                try {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(str6));
                    str3 = str6;
                } catch (Exception unused) {
                    str3 = str6;
                    intent = new Intent(this, (Class<?>) SplashActivity.class);
                }
            } else {
                intent = new Intent(this, (Class<?>) SplashActivity.class);
            }
        } catch (Exception unused2) {
        }
        String str7 = str3;
        int i = getSharedPreferences("DataPreferences", 0).getInt("NOTIFICATION_ID", 0) + 1;
        getSharedPreferences("DataPreferences", 0).edit().putInt("NOTIFICATION_ID", i).apply();
        intent.addFlags(67108864);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        PendingIntent activity = PendingIntent.getActivity(this, i, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 26) {
            w1.a.g();
            NotificationChannel notificationChannelB = w1.a.b(getString(q5.o.app_name).toLowerCase().replace(" ", "-") + "-channel", getString(q5.o.app_name));
            notificationManager.createNotificationChannel(notificationChannelB);
            mVar = new m(getApplicationContext(), notificationChannelB.getId());
        } else {
            mVar = new m(getApplicationContext(), null);
        }
        String str8 = (String) eVar2.get("title");
        String str9 = (String) eVar2.get("body");
        if (str9 == null) {
            str9 = "";
        }
        int i10 = j.ic_stat_notification;
        Notification notification = mVar.f5465s;
        notification.icon = i10;
        mVar.f5453e = m.b(str8);
        mVar.f = m.b(str9);
        mVar.c(16, true);
        notification.sound = defaultUri;
        notification.audioStreamType = -1;
        notification.audioAttributes = l.a(l.d(l.c(l.b(), 4), 5));
        mVar.f5454g = activity;
        String str10 = (String) eVar2.get("imgUrl");
        if (str10 == null || str10.isEmpty()) {
            k kVar = new k(3, false);
            kVar.f5448x = m.b(str9);
            aVar = kVar;
        } else {
            try {
                n nVarE = b.a(this).f2197z.b(this).i().E(str10);
                o7.e eVar3 = new o7.e();
                nVarE.C(eVar3, eVar3, nVarE, f.f11597b);
                bitmap = (Bitmap) eVar3.get();
            } catch (InterruptedException | ExecutionException unused3) {
            }
            if (bitmap != null) {
                h0.j jVar = new h0.j(3, false);
                IconCompat iconCompat = new IconCompat(1);
                iconCompat.f660b = bitmap;
                jVar.f5445x = iconCompat;
                aVar = jVar;
            } else {
                k kVar2 = new k(3, false);
                kVar2.f5448x = m.b(str9);
                aVar = kVar2;
            }
        }
        mVar.e(aVar);
        notificationManager.notify(i, mVar.a());
        C.execute(new d(this, str8, str9, str10, str7));
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d() {
        FirebaseMessaging firebaseMessaging;
        l4.a aVar = FirebaseMessaging.f3035l;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = FirebaseMessaging.getInstance(g.c());
        }
        p pVar = firebaseMessaging.f3044h;
        nc.l lVar = new nc.l(0);
        pVar.getClass();
        pVar.f6707b.h(new j9.n(j9.j.f6689a, lVar, new p()));
        pVar.q();
    }
}

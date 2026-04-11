package com.playz.tv.firebase;

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
import c3.e;
import com.bumptech.glide.b;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.playz.tv.activities.PlayerActivity;
import com.playz.tv.activities.SplashActivity;
import e0.j;
import e0.k;
import e0.l;
import e0.m;
import ga.g;
import gc.i;
import gc.o;
import java.util.concurrent.ExecutionException;
import lb.h;
import o4.c;
import ub.n;
import x6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class PushService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(n nVar) {
        Intent intent;
        m mVar;
        e eVar;
        if (nVar.f12865v == null) {
            Bundle bundle = nVar.f12864u;
            s.e eVar2 = new s.e(0);
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        eVar2.put(str, str2);
                    }
                }
            }
            nVar.f12865v = eVar2;
        }
        s.e eVar3 = nVar.f12865v;
        try {
            String str3 = (String) eVar3.get("activity");
            if ("Player".equals(str3)) {
                intent = new Intent(this, (Class<?>) PlayerActivity.class);
                String str4 = (String) eVar3.get("path");
                if (TextUtils.isEmpty(str4)) {
                    str4 = "pro";
                }
                intent.putExtra("links", str4);
                intent.putExtra("fromSplash", false);
            } else {
                intent = "openUrl".equals(str3) ? new Intent("android.intent.action.VIEW", Uri.parse((String) eVar3.get("url"))) : new Intent(this, (Class<?>) SplashActivity.class);
            }
        } catch (Exception unused) {
            intent = new Intent(this, (Class<?>) SplashActivity.class);
        }
        int i = getSharedPreferences("DataPreferences", 0).getInt("NOTIFICATION_ID", 0) + 1;
        getSharedPreferences("DataPreferences", 0).edit().putInt("NOTIFICATION_ID", i).apply();
        intent.addFlags(67108864);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        int i10 = Build.VERSION.SDK_INT;
        PendingIntent activity = PendingIntent.getActivity(this, i, intent, 201326592);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Bitmap bitmap = null;
        if (i10 >= 26) {
            h.t();
            NotificationChannel notificationChannelE = h.e(getString(o.app_name).toLowerCase().replace(" ", "-") + "-channel", getString(o.app_name));
            notificationManager.createNotificationChannel(notificationChannelE);
            mVar = new m(getApplicationContext(), notificationChannelE.getId());
        } else {
            mVar = new m(getApplicationContext(), null);
        }
        String str5 = (String) eVar3.get("body");
        if (str5 == null) {
            str5 = "";
        }
        int i11 = i.ic_stat_noti;
        Notification notification = mVar.f4272s;
        notification.icon = i11;
        mVar.f4260e = m.b((CharSequence) eVar3.get("title"));
        mVar.f = m.b(str5);
        mVar.c(16, true);
        notification.sound = defaultUri;
        notification.audioStreamType = -1;
        notification.audioAttributes = l.a(l.d(l.c(l.b(), 4), 5));
        mVar.f4261g = activity;
        String str6 = (String) eVar3.get("imgUrl");
        if (str6 == null || str6.isEmpty()) {
            k kVar = new k(1, false);
            kVar.f4255w = m.b(str5);
            eVar = kVar;
        } else {
            try {
                com.bumptech.glide.k kVarI = b.a(this).f2764y.b(this).i().I(str6);
                t6.e eVar4 = new t6.e();
                kVarI.E(eVar4, eVar4, kVarI, f.f14281b);
                bitmap = (Bitmap) eVar4.get();
            } catch (InterruptedException | ExecutionException unused2) {
            }
            if (bitmap != null) {
                j jVar = new j(1, false);
                IconCompat iconCompat = new IconCompat(1);
                iconCompat.f986b = bitmap;
                jVar.f4252w = iconCompat;
                eVar = jVar;
            } else {
                k kVar2 = new k(1, false);
                kVar2.f4255w = m.b(str5);
                eVar = kVar2;
            }
        }
        mVar.e(eVar);
        notificationManager.notify(i, mVar.a());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d() {
        FirebaseMessaging firebaseMessaging;
        c cVar = FirebaseMessaging.f3572l;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = FirebaseMessaging.getInstance(g.c());
        }
        o8.o oVar = firebaseMessaging.f3581h;
        r2.h hVar = new r2.h(7);
        oVar.getClass();
        oVar.f9440b.i(new o8.m(o8.i.f9422a, hVar, new o8.o()));
        oVar.q();
    }
}

package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import be.h;
import cc.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SessionLifecycleService extends Service {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HandlerThread f3593u = new HandlerThread("FirebaseSessions_HandlerThread");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public t0 f3594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Messenger f3595w;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger messenger = Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
        if (messenger != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = messenger;
            t0 t0Var = this.f3594v;
            if (t0Var != null) {
                t0Var.sendMessage(messageObtain);
            }
        }
        Messenger messenger2 = this.f3595w;
        if (messenger2 != null) {
            return messenger2.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = this.f3593u;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        h.d(looper, "handlerThread.looper");
        this.f3594v = new t0(looper);
        this.f3595w = new Messenger(this.f3594v);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f3593u.quit();
    }
}

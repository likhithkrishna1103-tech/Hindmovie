package c2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.e9;
import com.google.firebase.messaging.FirebaseMessaging;
import g4.m0;
import java.util.Objects;
import k8.h1;
import k8.j2;
import k8.k1;
import k8.p0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2259b;

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        ((FirebaseMessaging) ((j2) this.f2259b).f7260x).f3576b.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        KeyEvent keyEvent;
        switch (this.f2258a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!isInitialStickyBroadcast()) {
                    f fVar = (f) this.f2259b;
                    fVar.a(b.b(context, intent, (p1.d) fVar.f2306j, (wb.c) fVar.i));
                }
                break;
            case 1:
                com.bumptech.glide.manager.r.A.execute(new com.bumptech.glide.manager.q((com.bumptech.glide.manager.r) this.f2259b, 2));
                break;
            case 2:
                if (Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    ((h4.l) ((u5.d) ((m0) this.f2259b).f5118k.f5868w).f12784v).f5824a.dispatchMediaButtonEvent(keyEvent);
                }
                break;
            case 3:
                x.a((x) this.f2259b);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((androidx.fragment.app.h) this.f2259b).l();
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                k1 k1Var = (k1) this.f2259b;
                if (intent == null) {
                    p0 p0Var = k1Var.C;
                    k1.f(p0Var);
                    p0Var.D.d("App receiver called with null intent");
                    break;
                } else {
                    String action = intent.getAction();
                    if (action == null) {
                        p0 p0Var2 = k1Var.C;
                        k1.f(p0Var2);
                        p0Var2.D.d("App receiver called with null action");
                        break;
                    } else if (!action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                        p0 p0Var3 = k1Var.C;
                        k1.f(p0Var3);
                        p0Var3.D.d("App receiver called with unknown action");
                        break;
                    } else {
                        e9.a();
                        if (k1Var.A.A1(null, k8.w.I0)) {
                            p0 p0Var4 = k1Var.C;
                            k1.f(p0Var4);
                            p0Var4.I.d("App receiver notified triggers are available");
                            h1 h1Var = k1Var.D;
                            k1.f(h1Var);
                            androidx.fragment.app.e eVar = new androidx.fragment.app.e(12);
                            eVar.f1266v = k1Var;
                            h1Var.y1(eVar);
                            break;
                        }
                    }
                }
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ((s1.s) this.f2259b).f11697a.execute(new o2.i0(this, 9, context));
                break;
            default:
                j2 j2Var = (j2) this.f2259b;
                if (j2Var != null && j2Var.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    j2 j2Var2 = (j2) this.f2259b;
                    ((FirebaseMessaging) j2Var2.f7260x).getClass();
                    FirebaseMessaging.b(j2Var2, 0L);
                    ((FirebaseMessaging) ((j2) this.f2259b).f7260x).f3576b.unregisterReceiver(this);
                    this.f2259b = null;
                }
                break;
        }
    }

    public /* synthetic */ e(int i, Object obj) {
        this.f2258a = i;
        this.f2259b = obj;
    }

    public e(k1 k1Var) {
        this.f2258a = 5;
        this.f2259b = k1Var;
    }
}

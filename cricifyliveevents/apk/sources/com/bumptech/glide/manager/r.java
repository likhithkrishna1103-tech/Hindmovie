package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.q8;
import f9.f0;
import f9.p1;
import f9.r1;
import f9.w0;
import i2.x;
import java.util.Objects;
import k4.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2280b;

    public /* synthetic */ r(int i, Object obj) {
        this.f2279a = i;
        this.f2280b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        KeyEvent keyEvent;
        switch (this.f2279a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t.B.execute(new s((t) this.f2280b, 2));
                break;
            case 1:
                r1 r1Var = (r1) this.f2280b;
                if (intent != null) {
                    String action = intent.getAction();
                    if (action != null) {
                        int iHashCode = action.hashCode();
                        if (iHashCode != -1928239649) {
                            if (iHashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                                w0 w0Var = r1Var.A;
                                r1.g(w0Var);
                                w0Var.J.a("[sgtm] App Receiver notified batches are available");
                                p1 p1Var = r1Var.B;
                                r1.g(p1Var);
                                p1Var.v1(new androidx.fragment.app.m(10, this));
                            }
                            break;
                        } else if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                            q8.a();
                            if (r1Var.f4366y.w1(null, f0.R0)) {
                                w0 w0Var2 = r1Var.A;
                                r1.g(w0Var2);
                                w0Var2.J.a("App receiver notified triggers are available");
                                p1 p1Var2 = r1Var.B;
                                r1.g(p1Var2);
                                p1Var2.v1(new androidx.fragment.app.m(11, r1Var));
                                break;
                            }
                        }
                        w0 w0Var3 = r1Var.A;
                        r1.g(w0Var3);
                        w0Var3.E.a("App receiver called with unknown action");
                    } else {
                        w0 w0Var4 = r1Var.A;
                        r1.g(w0Var4);
                        w0Var4.E.a("App receiver called with null action");
                    }
                } else {
                    w0 w0Var5 = r1Var.A;
                    r1.g(w0Var5);
                    w0Var5.E.a("App receiver called with null intent");
                }
                break;
            case 2:
                ((androidx.fragment.app.h) this.f2280b).m();
                break;
            case 3:
                if (!isInitialStickyBroadcast()) {
                    i2.f fVar = (i2.f) this.f2280b;
                    fVar.d(i2.c.b(context, intent, (v1.c) fVar.f5999j, (p6.d) fVar.i));
                }
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                if (Objects.equals(intent.getAction(), "android.intent.action.MEDIA_BUTTON") && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    ((l4.m) ((p6.d) ((l0) this.f2280b).f7063k.f7706x).f10037w).f7741a.dispatchMediaButtonEvent(keyEvent);
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                x.a((x) this.f2280b);
                break;
            default:
                ((y1.s) this.f2280b).f14602a.execute(new nc.i(16, this, context));
                break;
        }
    }

    public r(r1 r1Var) {
        this.f2279a = 1;
        this.f2280b = r1Var;
    }
}

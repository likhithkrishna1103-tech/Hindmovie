package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends f1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2944y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f2945z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(i1 i1Var, Object obj, Object obj2, int i) {
        super(i1Var, true);
        this.f2944y = i;
        this.A = obj;
        this.B = obj2;
        this.f2945z = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        s0 s0VarAsInterface;
        Bundle bundle;
        switch (this.f2944y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    t7.v.h((Context) this.A);
                    i1 i1Var = (i1) this.f2945z;
                    try {
                        s0VarAsInterface = v0.asInterface(b8.f.c((Context) this.A, b8.f.f1925b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
                    } catch (b8.b e10) {
                        i1Var.f(e10, true, false);
                        s0VarAsInterface = null;
                    }
                    i1Var.f3049h = s0VarAsInterface;
                    if (((i1) this.f2945z).f3049h != null) {
                        int iA = b8.f.a((Context) this.A, ModuleDescriptor.MODULE_ID);
                        d1 d1Var = new d1(106000L, Math.max(iA, r2), b8.f.d((Context) this.A, ModuleDescriptor.MODULE_ID, false) < iA, null, null, null, (Bundle) this.B, k8.c2.b((Context) this.A));
                        s0 s0Var = ((i1) this.f2945z).f3049h;
                        t7.v.h(s0Var);
                        s0Var.initialize(new a8.b((Context) this.A), d1Var, this.f2966u);
                    } else {
                        Log.w(((i1) this.f2945z).f3043a, "Failed to connect to measurement client.");
                    }
                } catch (Exception e11) {
                    ((i1) this.f2945z).f(e11, true, false);
                    return;
                }
                break;
            case 1:
                s0 s0Var2 = ((i1) this.f2945z).f3049h;
                t7.v.h(s0Var2);
                s0Var2.getMaxUserProperties((String) this.A, (t0) this.B);
                break;
            case 2:
                if (((Bundle) this.B) != null) {
                    bundle = new Bundle();
                    if (((Bundle) this.B).containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = ((Bundle) this.B).get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                } else {
                    bundle = null;
                }
                s0 s0Var3 = ((h1) this.f2945z).f3034u.f3049h;
                t7.v.h(s0Var3);
                s0Var3.onActivityCreated(new a8.b((Activity) this.A), bundle, this.f2967v);
                break;
            default:
                s0 s0Var4 = ((h1) this.f2945z).f3034u.f3049h;
                t7.v.h(s0Var4);
                s0Var4.onActivitySaveInstanceState(new a8.b((Activity) this.A), (t0) this.B, this.f2967v);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public void b() {
        switch (this.f2944y) {
            case 1:
                ((t0) this.B).h(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(h1 h1Var, Activity activity, t0 t0Var) {
        super(h1Var.f3034u, true);
        this.f2944y = 3;
        this.A = activity;
        this.B = t0Var;
        this.f2945z = h1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(h1 h1Var, Bundle bundle, Activity activity) {
        super(h1Var.f3034u, true);
        this.f2944y = 2;
        this.B = bundle;
        this.A = activity;
        this.f2945z = h1Var;
    }
}

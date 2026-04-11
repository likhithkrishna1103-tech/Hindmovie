package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends g1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object B;
    public final /* synthetic */ Object C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2740z = 3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(j1 j1Var, Activity activity, g0 g0Var) {
        super(j1Var.f2492v, true);
        this.B = activity;
        this.C = g0Var;
        this.A = j1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        Boolean boolValueOf;
        Bundle bundle;
        switch (this.f2740z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Context context = (Context) this.B;
                    o8.u.g(context);
                    String strA = f9.h2.a(context);
                    Resources resources = context.getResources();
                    if (TextUtils.isEmpty(strA)) {
                        strA = f9.h2.a(context);
                    }
                    int identifier = resources.getIdentifier("google_analytics_force_disable_updates", "bool", strA);
                    j0 j0VarAsInterface = null;
                    if (identifier == 0) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(resources.getBoolean(identifier));
                        } catch (Resources.NotFoundException unused) {
                            boolValueOf = null;
                        }
                    }
                    k1 k1Var = (k1) this.A;
                    boolean z10 = boolValueOf == null || !boolValueOf.booleanValue();
                    k1Var.getClass();
                    try {
                        j0VarAsInterface = i0.asInterface(w8.d.c(context, z10 ? w8.d.f14113c : w8.d.f14112b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
                    } catch (w8.a e9) {
                        k1Var.d(e9, true, false);
                    }
                    k1Var.f = j0VarAsInterface;
                    if (k1Var.f != null) {
                        int iA = w8.d.a(context, ModuleDescriptor.MODULE_ID);
                        t0 t0Var = new t0(133005L, Math.max(iA, r6), Boolean.TRUE.equals(boolValueOf) || w8.d.d(context, ModuleDescriptor.MODULE_ID, false) < iA, (Bundle) this.C, f9.h2.a(context));
                        j0 j0Var = k1Var.f;
                        o8.u.g(j0Var);
                        j0Var.initialize(new v8.b(context), t0Var, this.f2453v);
                    } else {
                        Log.w("FA", "Failed to connect to measurement client.");
                    }
                } catch (Exception e10) {
                    ((k1) this.A).d(e10, true, false);
                    return;
                }
                break;
            case 1:
                j0 j0Var2 = ((k1) this.A).f;
                o8.u.g(j0Var2);
                j0Var2.getMaxUserProperties((String) this.B, (g0) this.C);
                break;
            case 2:
                Bundle bundle2 = (Bundle) this.C;
                if (bundle2 != null) {
                    bundle = new Bundle();
                    if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = bundle2.get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                } else {
                    bundle = null;
                }
                j0 j0Var3 = ((j1) this.A).f2492v.f;
                o8.u.g(j0Var3);
                j0Var3.onActivityCreatedByScionActivityInfo(v0.a((Activity) this.B), bundle, this.f2454w);
                break;
            default:
                j0 j0Var4 = ((j1) this.A).f2492v.f;
                o8.u.g(j0Var4);
                j0Var4.onActivitySaveInstanceStateByScionActivityInfo(v0.a((Activity) this.B), (g0) this.C, this.f2454w);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public void b() {
        switch (this.f2740z) {
            case 1:
                ((g0) this.C).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(j1 j1Var, Bundle bundle, Activity activity) {
        super(j1Var.f2492v, true);
        this.C = bundle;
        this.B = activity;
        this.A = j1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(k1 k1Var, Context context, Bundle bundle) {
        super(k1Var, true);
        this.B = context;
        this.C = bundle;
        this.A = k1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(k1 k1Var, String str, g0 g0Var) {
        super(k1Var, true);
        this.B = str;
        this.C = g0Var;
        Objects.requireNonNull(k1Var);
        this.A = k1Var;
    }
}

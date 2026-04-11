package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;
import com.google.android.gms.internal.measurement.z3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends z3 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ t f1030w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q f1031x;

    public p(q qVar, t tVar) {
        this.f1031x = qVar;
        this.f1030w = tVar;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final View p(int i) {
        t tVar = this.f1030w;
        if (tVar.q()) {
            return tVar.p(i);
        }
        Dialog dialog = this.f1031x.D0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final boolean q() {
        return this.f1030w.q() || this.f1031x.H0;
    }
}

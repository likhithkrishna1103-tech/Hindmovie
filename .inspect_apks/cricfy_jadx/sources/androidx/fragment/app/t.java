package androidx.fragment.app;

import android.view.View;
import com.google.android.gms.internal.measurement.z3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends z3 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ y f1074w;

    public t(y yVar) {
        this.f1074w = yVar;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final View p(int i) {
        y yVar = this.f1074w;
        View view = yVar.f1103b0;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + yVar + " does not have a view");
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final boolean q() {
        return this.f1074w.f1103b0 != null;
    }
}

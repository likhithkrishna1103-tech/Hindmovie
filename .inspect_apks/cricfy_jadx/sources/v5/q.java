package v5;

import android.content.DialogInterface;
import v1.l1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ l1 f13443v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ s f13444w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ kb.d f13445x;

    public /* synthetic */ q(l1 l1Var, s sVar, kb.d dVar) {
        this.f13443v = l1Var;
        this.f13444w = sVar;
        this.f13445x = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        s.V(this.f13443v, this.f13444w, this.f13445x);
    }
}

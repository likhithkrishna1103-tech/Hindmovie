package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f1135v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b5.e f1136w;

    public LegacySavedStateHandleController$tryToAddRecreator$1(u uVar, b5.e eVar) {
        this.f1135v = uVar;
        this.f1136w = eVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar == m.ON_START) {
            this.f1135v.f(this);
            this.f1136w.g();
        }
    }
}

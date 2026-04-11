package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f1133v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f1134w;

    public DefaultLifecycleObserverAdapter(e eVar, q qVar) {
        ge.i.e(eVar, "defaultLifecycleObserver");
        this.f1133v = eVar;
        this.f1134w = qVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        int i = f.f1155a[mVar.ordinal()];
        e eVar = this.f1133v;
        switch (i) {
            case 1:
                eVar.getClass();
                break;
            case 2:
                eVar.getClass();
                break;
            case 3:
                eVar.g();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                eVar.getClass();
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                eVar.getClass();
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                eVar.getClass();
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        q qVar = this.f1134w;
        if (qVar != null) {
            qVar.a(sVar, mVar);
        }
    }
}

package a5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f272v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f273w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f274x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f275y;

    public e(int i, int i10, String str, String str2) {
        ge.i.e(str, "from");
        ge.i.e(str2, "to");
        this.f272v = i;
        this.f273w = i10;
        this.f274x = str;
        this.f275y = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        ge.i.e(eVar, "other");
        int i = this.f272v - eVar.f272v;
        return i == 0 ? this.f273w - eVar.f273w : i;
    }
}

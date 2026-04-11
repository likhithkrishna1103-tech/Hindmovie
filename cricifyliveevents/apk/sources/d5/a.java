package d5;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3390v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f3391w;

    public void b(String str) {
        i.e(str, "message");
    }

    public void c(String str, Exception exc) {
        i.e(str, "message");
    }

    @Override // d5.f
    public String s() {
        return this.f3391w;
    }

    public String toString() {
        switch (this.f3390v) {
            case 3:
                return "<" + this.f3391w + '>';
            default:
                return super.toString();
        }
    }

    public a(int i, String str) {
        this.f3390v = i;
        switch (i) {
            case 3:
                this.f3391w = str;
                break;
            default:
                i.e(str, "query");
                this.f3391w = str;
                break;
        }
    }

    @Override // d5.f
    public void a(e eVar) {
    }
}

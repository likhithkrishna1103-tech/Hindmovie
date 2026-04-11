package m5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0.f[] f8340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8342c;

    public k() {
        this.f8340a = null;
        this.f8342c = 0;
    }

    public l0.f[] getPathData() {
        return this.f8340a;
    }

    public String getPathName() {
        return this.f8341b;
    }

    public void setPathData(l0.f[] fVarArr) {
        if (!u8.a.e(this.f8340a, fVarArr)) {
            this.f8340a = u8.a.q(fVarArr);
            return;
        }
        l0.f[] fVarArr2 = this.f8340a;
        for (int i = 0; i < fVarArr.length; i++) {
            fVarArr2[i].f7607a = fVarArr[i].f7607a;
            int i10 = 0;
            while (true) {
                float[] fArr = fVarArr[i].f7608b;
                if (i10 < fArr.length) {
                    fVarArr2[i].f7608b[i10] = fArr[i10];
                    i10++;
                }
            }
        }
    }

    public k(k kVar) {
        this.f8340a = null;
        this.f8342c = 0;
        this.f8341b = kVar.f8341b;
        this.f8340a = u8.a.q(kVar.f8340a);
    }
}

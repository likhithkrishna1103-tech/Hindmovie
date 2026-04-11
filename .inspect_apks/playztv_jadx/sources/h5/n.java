package h5;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i0.f[] f5914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5916c;

    public n() {
        this.f5914a = null;
        this.f5916c = 0;
    }

    public i0.f[] getPathData() {
        return this.f5914a;
    }

    public String getPathName() {
        return this.f5915b;
    }

    public void setPathData(i0.f[] fVarArr) {
        if (!ga.b.c(this.f5914a, fVarArr)) {
            this.f5914a = ga.b.j(fVarArr);
            return;
        }
        i0.f[] fVarArr2 = this.f5914a;
        for (int i = 0; i < fVarArr.length; i++) {
            fVarArr2[i].f6166a = fVarArr[i].f6166a;
            int i10 = 0;
            while (true) {
                float[] fArr = fVarArr[i].f6167b;
                if (i10 < fArr.length) {
                    fVarArr2[i].f6167b[i10] = fArr[i10];
                    i10++;
                }
            }
        }
    }

    public n(n nVar) {
        this.f5914a = null;
        this.f5916c = 0;
        this.f5915b = nVar.f5915b;
        this.f5914a = ga.b.j(nVar.f5914a);
    }
}

package j9;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6890d;

    public j0(int i, int i10, int i11, int i12) {
        this.f6887a = i;
        this.f6888b = i10;
        this.f6889c = i11;
        this.f6890d = i12;
    }

    public boolean a(int i) {
        if (i == 1) {
            if (this.f6887a - this.f6888b <= 1) {
                return false;
            }
        } else if (this.f6889c - this.f6890d <= 1) {
            return false;
        }
        return true;
    }
}

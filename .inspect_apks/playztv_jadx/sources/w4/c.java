package w4;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f13715u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13716v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f13717w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f13718x;

    public c(int i, int i10, String str, String str2) {
        h.e(str, "from");
        h.e(str2, "to");
        this.f13715u = i;
        this.f13716v = i10;
        this.f13717w = str;
        this.f13718x = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        h.e(cVar, "other");
        int i = this.f13715u - cVar.f13715u;
        return i == 0 ? this.f13716v - cVar.f13716v : i;
    }
}

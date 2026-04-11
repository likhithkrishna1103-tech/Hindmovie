package v1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j extends IOException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f13143v = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f13144u;

    public j(int i) {
        this.f13144u = i;
    }

    public j(Exception exc, int i) {
        super(exc);
        this.f13144u = i;
    }

    public j(String str, int i) {
        super(str);
        this.f13144u = i;
    }

    public j(String str, Exception exc, int i) {
        super(str, exc);
        this.f13144u = i;
    }
}

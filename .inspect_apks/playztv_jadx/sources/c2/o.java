package c2;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class o extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public o(Status status) {
        int i = status.f2871u;
        String str = status.f2872v;
        super(i + ": " + (str == null ? "" : str));
    }
}

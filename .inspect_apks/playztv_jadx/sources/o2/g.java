package o2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends IOException {
    public g(int i) {
        this(i, -9223372036854775807L, -9223372036854775807L);
    }

    public g(int i, long j5, long j8) {
        String str;
        StringBuilder sb2 = new StringBuilder("Illegal clipping: ");
        if (i != 0) {
            if (i == 1) {
                str = "not seekable to start";
            } else if (i != 2) {
                str = "unknown";
            } else {
                s1.d.g((j5 == -9223372036854775807L || j8 == -9223372036854775807L) ? false : true);
                str = "start exceeds end. Start time: " + j5 + ", End time: " + j8;
            }
        } else {
            str = "invalid period count";
        }
        sb2.append(str);
        super(sb2.toString());
    }
}

package s2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends IOException {
    public l(Throwable th) {
        String str;
        StringBuilder sb2 = new StringBuilder("Unexpected ");
        sb2.append(th.getClass().getSimpleName());
        if (th.getMessage() != null) {
            str = ": " + th.getMessage();
        } else {
            str = "";
        }
        sb2.append(str);
        super(sb2.toString(), th);
    }
}

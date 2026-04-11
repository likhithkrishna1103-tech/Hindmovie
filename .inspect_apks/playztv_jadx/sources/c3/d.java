package c3;

import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends n0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, int i) {
        super(str, null, false, 1);
        switch (i) {
            case 1:
                super("Missing required field: ".concat(str), null, true, 4);
                break;
            default:
                break;
        }
    }
}

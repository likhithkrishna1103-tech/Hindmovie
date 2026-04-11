package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(String str) {
        super(str);
        be.h.e(str, "message");
    }

    public y0() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}

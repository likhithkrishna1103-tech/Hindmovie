package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3113c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3115b;

    static {
        byte b10 = (byte) (0 | 1);
        if (b10 != 1) {
            StringBuilder sb2 = new StringBuilder();
            if ((b10 & 1) == 0) {
                sb2.append(" hasDifferentDmaOwner");
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(sb2)));
        }
        byte b11 = (byte) (0 | 1);
        if (b11 != 1) {
            StringBuilder sb3 = new StringBuilder();
            if ((b11 & 1) == 0) {
                sb3.append(" hasDifferentDmaOwner");
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(sb3)));
        }
        byte b12 = (byte) (0 | 1);
        if (b12 == 1) {
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        if ((b12 & 1) == 0) {
            sb4.append(" hasDifferentDmaOwner");
        }
        throw new IllegalStateException("Missing required properties:".concat(String.valueOf(sb4)));
    }

    public n0(int i, int i10) {
        this.f3114a = i;
        this.f3115b = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return v.e.a(this.f3114a, n0Var.f3114a) && v.e.a(this.f3115b, n0Var.f3115b);
    }

    public final int hashCode() {
        return ((v.e.c(this.f3114a) ^ (-485106924)) * 583896283) ^ v.e.c(this.f3115b);
    }

    public final String toString() {
        int i = this.f3114a;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        int i10 = this.f3115b;
        return "FileComplianceOptions{fileOwner=, hasDifferentDmaOwner=false, fileChecks=" + str + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + (i10 != 1 ? i10 != 2 ? i10 != 3 ? "null" : "WRITE_ONLY" : "READ_ONLY" : "READ_AND_WRITE") + "}";
    }
}

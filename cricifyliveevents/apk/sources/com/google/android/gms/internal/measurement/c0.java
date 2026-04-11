package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2337b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2338a;

    public c0(int i) {
        this.f2338a = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        int i = ((c0) obj).f2338a;
        int i10 = this.f2338a;
        if (i10 != 0) {
            return i10 == i;
        }
        throw null;
    }

    public final int hashCode() {
        int i = this.f2338a;
        if (i != 0) {
            return ((i ^ (-485106924)) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i = this.f2338a;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        StringBuilder sb = new StringBuilder("READ_AND_WRITE".length() + str.length() + "".length() + 73 + 91 + 1);
        sb.append("FileComplianceOptions{fileOwner=, hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        sb.append(", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=");
        sb.append("READ_AND_WRITE");
        sb.append("}");
        return sb.toString();
    }
}

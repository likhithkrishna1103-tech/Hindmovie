package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends g {
    public final int A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f699z;

    public f(byte[] bArr, int i, int i10) {
        super(bArr);
        g.b(i, i + i10, bArr.length);
        this.f699z = i;
        this.A = i10;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte a(int i) {
        int i10 = this.A;
        if (((i10 - (i + 1)) | i) >= 0) {
            return this.f706w[this.f699z + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(l0.e.g(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(q4.a.m(i, i10, "Index > length: ", ", "));
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final void d(int i, byte[] bArr) {
        System.arraycopy(this.f706w, this.f699z, bArr, 0, i);
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int f() {
        return this.f699z;
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final byte g(int i) {
        return this.f706w[this.f699z + i];
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public final int size() {
        return this.A;
    }
}

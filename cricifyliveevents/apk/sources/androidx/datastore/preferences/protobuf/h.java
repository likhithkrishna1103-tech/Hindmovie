package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f711e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f713h;
    public int i = Integer.MAX_VALUE;

    public h(byte[] bArr, int i, int i10, boolean z10) {
        this.f709c = bArr;
        this.f710d = i10 + i;
        this.f = i;
        this.f712g = i;
    }

    public final long A() throws z {
        int i = this.f;
        if (this.f710d - i < 8) {
            throw z.e();
        }
        this.f = i + 8;
        byte[] bArr = this.f709c;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int B() {
        int i;
        int i10 = this.f;
        int i11 = this.f710d;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f709c;
            byte b8 = bArr[i10];
            if (b8 >= 0) {
                this.f = i12;
                return b8;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b8;
                if (i14 < 0) {
                    i = i14 ^ (-128);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    if (i16 >= 0) {
                        i = i16 ^ 16256;
                    } else {
                        int i17 = i10 + 4;
                        int i18 = i16 ^ (bArr[i15] << 21);
                        if (i18 < 0) {
                            i = (-2080896) ^ i18;
                        } else {
                            i15 = i10 + 5;
                            byte b10 = bArr[i17];
                            int i19 = (i18 ^ (b10 << 28)) ^ 266354560;
                            if (b10 < 0) {
                                i17 = i10 + 6;
                                if (bArr[i15] < 0) {
                                    i15 = i10 + 7;
                                    if (bArr[i17] < 0) {
                                        i17 = i10 + 8;
                                        if (bArr[i15] < 0) {
                                            i15 = i10 + 9;
                                            if (bArr[i17] < 0) {
                                                int i20 = i10 + 10;
                                                if (bArr[i15] >= 0) {
                                                    i13 = i20;
                                                    i = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i19;
                            }
                            i = i19;
                        }
                        i13 = i17;
                    }
                    i13 = i15;
                }
                this.f = i13;
                return i;
            }
        }
        return (int) D();
    }

    public final long C() {
        long j4;
        long j7;
        long j10;
        long j11;
        int i = this.f;
        int i10 = this.f710d;
        if (i10 != i) {
            int i11 = i + 1;
            byte[] bArr = this.f709c;
            byte b8 = bArr[i];
            if (b8 >= 0) {
                this.f = i11;
                return b8;
            }
            if (i10 - i11 >= 9) {
                int i12 = i + 2;
                int i13 = (bArr[i11] << 7) ^ b8;
                if (i13 < 0) {
                    j4 = i13 ^ (-128);
                } else {
                    int i14 = i + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        j4 = i15 ^ 16256;
                        i12 = i14;
                    } else {
                        int i16 = i + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            j11 = (-2080896) ^ i17;
                        } else {
                            long j12 = i17;
                            i12 = i + 5;
                            long j13 = j12 ^ (((long) bArr[i16]) << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i16 = i + 6;
                                long j14 = j13 ^ (((long) bArr[i12]) << 35);
                                if (j14 < 0) {
                                    j7 = -34093383808L;
                                } else {
                                    i12 = i + 7;
                                    j13 = j14 ^ (((long) bArr[i16]) << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i16 = i + 8;
                                        j14 = j13 ^ (((long) bArr[i12]) << 49);
                                        if (j14 < 0) {
                                            j7 = -558586000294016L;
                                        } else {
                                            i12 = i + 9;
                                            long j15 = (j14 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i18 = i + 10;
                                                if (bArr[i12] >= 0) {
                                                    i12 = i18;
                                                }
                                            }
                                            j4 = j15;
                                        }
                                    }
                                }
                                j11 = j7 ^ j14;
                            }
                            j4 = j10 ^ j13;
                        }
                        i12 = i16;
                        j4 = j11;
                    }
                }
                this.f = i12;
                return j4;
            }
        }
        return D();
    }

    public final long D() throws z {
        long j4 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i10 = this.f;
            if (i10 == this.f710d) {
                throw z.e();
            }
            this.f = i10 + 1;
            byte b8 = this.f709c[i10];
            j4 |= ((long) (b8 & 127)) << i;
            if ((b8 & 128) == 0) {
                return j4;
            }
        }
        throw z.c();
    }

    public final void E() {
        int i = this.f710d + this.f711e;
        this.f710d = i;
        int i10 = i - this.f712g;
        int i11 = this.i;
        if (i10 <= i11) {
            this.f711e = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f711e = i12;
        this.f710d = i - i12;
    }

    public final void F(int i) throws z {
        if (i >= 0) {
            int i10 = this.f710d;
            int i11 = this.f;
            if (i <= i10 - i11) {
                this.f = i11 + i;
                return;
            }
        }
        if (i >= 0) {
            throw z.e();
        }
        throw z.d();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void a(int i) throws z {
        if (this.f713h != i) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int b() {
        return this.f - this.f712g;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean c() {
        return this.f == this.f710d;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void d(int i) {
        this.i = i;
        E();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int e(int i) throws z {
        if (i < 0) {
            throw z.d();
        }
        int iB = b() + i;
        if (iB < 0) {
            throw new z("Failed to parse the message.");
        }
        int i10 = this.i;
        if (iB > i10) {
            throw z.e();
        }
        this.i = iB;
        E();
        return i10;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean f() {
        return C() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // androidx.datastore.preferences.protobuf.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.preferences.protobuf.g g() throws androidx.datastore.preferences.protobuf.z {
        /*
            r4 = this;
            int r0 = r4.B()
            byte[] r1 = r4.f709c
            if (r0 <= 0) goto L19
            int r2 = r4.f710d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            androidx.datastore.preferences.protobuf.g r1 = androidx.datastore.preferences.protobuf.g.c(r1, r3, r0)
            int r2 = r4.f
            int r2 = r2 + r0
            r4.f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            androidx.datastore.preferences.protobuf.g r0 = androidx.datastore.preferences.protobuf.g.f703x
            return r0
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.f710d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f = r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r0 = androidx.datastore.preferences.protobuf.x.f809b
        L35:
            androidx.datastore.preferences.protobuf.g r1 = androidx.datastore.preferences.protobuf.g.f703x
            androidx.datastore.preferences.protobuf.g r1 = new androidx.datastore.preferences.protobuf.g
            r1.<init>(r0)
            return r1
        L3d:
            androidx.datastore.preferences.protobuf.z r0 = androidx.datastore.preferences.protobuf.z.d()
            throw r0
        L42:
            androidx.datastore.preferences.protobuf.z r0 = androidx.datastore.preferences.protobuf.z.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.g():androidx.datastore.preferences.protobuf.g");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final double h() {
        return Double.longBitsToDouble(A());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int i() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int j() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long k() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final float l() {
        return Float.intBitsToFloat(z());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int m() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long n() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int o() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long p() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int q() {
        int iB = B();
        return (-(iB & 1)) ^ (iB >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long r() {
        long jC = C();
        return (-(jC & 1)) ^ (jC >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String s() throws z {
        int iB = B();
        if (iB > 0) {
            int i = this.f710d;
            int i10 = this.f;
            if (iB <= i - i10) {
                String str = new String(this.f709c, i10, iB, x.f808a);
                this.f += iB;
                return str;
            }
        }
        if (iB == 0) {
            return "";
        }
        if (iB < 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String t() throws z {
        int iB = B();
        if (iB > 0) {
            int i = this.f710d;
            int i10 = this.f;
            if (iB <= i - i10) {
                String strF = k1.f737a.f(this.f709c, i10, iB);
                this.f += iB;
                return strF;
            }
        }
        if (iB == 0) {
            return "";
        }
        if (iB <= 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int u() throws z {
        if (c()) {
            this.f713h = 0;
            return 0;
        }
        int iB = B();
        this.f713h = iB;
        if ((iB >>> 3) != 0) {
            return iB;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int v() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long w() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean x(int i) throws z {
        int i10 = i & 7;
        int i11 = 0;
        if (i10 != 0) {
            if (i10 == 1) {
                F(8);
                return true;
            }
            if (i10 == 2) {
                F(B());
                return true;
            }
            if (i10 == 3) {
                y();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw z.b();
            }
            F(4);
            return true;
        }
        int i12 = this.f710d - this.f;
        byte[] bArr = this.f709c;
        if (i12 >= 10) {
            while (i11 < 10) {
                int i13 = this.f;
                this.f = i13 + 1;
                if (bArr[i13] < 0) {
                    i11++;
                }
            }
            throw z.c();
        }
        while (i11 < 10) {
            int i14 = this.f;
            if (i14 == this.f710d) {
                throw z.e();
            }
            this.f = i14 + 1;
            if (bArr[i14] < 0) {
                i11++;
            }
        }
        throw z.c();
        return true;
    }

    public final int z() throws z {
        int i = this.f;
        if (this.f710d - i < 4) {
            throw z.e();
        }
        this.f = i + 4;
        byte[] bArr = this.f709c;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }
}

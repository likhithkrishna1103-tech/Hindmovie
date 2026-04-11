package ag;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h implements Serializable, Comparable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f430y = new h(new byte[0]);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f431v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient int f432w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient String f433x;

    public h(byte[] bArr) {
        ge.i.e(bArr, "data");
        this.f431v = bArr;
    }

    public int a() {
        return this.f431v.length;
    }

    public String b() {
        byte[] bArr = this.f431v;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b8 : bArr) {
            int i10 = i + 1;
            char[] cArr2 = bg.b.f1919a;
            cArr[i] = cArr2[(b8 >> 4) & 15];
            i += 2;
            cArr[i10] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }

    public byte[] c() {
        return this.f431v;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h hVar = (h) obj;
        ge.i.e(hVar, "other");
        int iA = a();
        int iA2 = hVar.a();
        int iMin = Math.min(iA, iA2);
        for (int i = 0; i < iMin; i++) {
            int iD = d(i) & 255;
            int iD2 = hVar.d(i) & 255;
            if (iD != iD2) {
                return iD < iD2 ? -1 : 1;
            }
        }
        if (iA == iA2) {
            return 0;
        }
        return iA < iA2 ? -1 : 1;
    }

    public byte d(int i) {
        return this.f431v[i];
    }

    public boolean e(int i, int i10, int i11, byte[] bArr) {
        ge.i.e(bArr, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f431v;
        return i <= bArr2.length - i11 && i10 >= 0 && i10 <= bArr.length - i11 && u8.a.c(i, i10, i11, bArr2, bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            int iA = hVar.a();
            byte[] bArr = this.f431v;
            if (iA == bArr.length && hVar.e(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(h hVar, int i) {
        ge.i.e(hVar, "other");
        return hVar.e(0, 0, i, this.f431v);
    }

    public String g(Charset charset) {
        ge.i.e(charset, "charset");
        return new String(this.f431v, charset);
    }

    public h h(int i, int i10) {
        if (i10 == -1234567890) {
            i10 = a();
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f431v;
        if (i10 <= bArr.length) {
            if (i10 - i >= 0) {
                return (i == 0 && i10 == bArr.length) ? this : new h(sd.i.j(bArr, i, i10));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }

    public int hashCode() {
        int i = this.f432w;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f431v);
        this.f432w = iHashCode;
        return iHashCode;
    }

    public h i() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f431v;
            if (i >= bArr.length) {
                return this;
            }
            byte b8 = bArr[i];
            if (b8 >= 65 && b8 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                ge.i.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i] = (byte) (b8 + 32);
                for (int i10 = i + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i10] = (byte) (b10 + 32);
                    }
                }
                return new h(bArrCopyOf);
            }
            i++;
        }
    }

    public final String j() {
        String str = this.f433x;
        if (str != null) {
            return str;
        }
        byte[] bArrC = c();
        ge.i.e(bArrC, "<this>");
        String str2 = new String(bArrC, ne.a.f9126a);
        this.f433x = str2;
        return str2;
    }

    public void k(e eVar, int i) {
        eVar.e0(i, this.f431v);
    }

    public String toString() {
        byte b8;
        int i;
        byte[] bArr = this.f431v;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            if (i10 >= length) {
                break;
            }
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                int i13 = i12 + 1;
                if (i12 == 64) {
                    break;
                }
                if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                    break;
                }
                i11 += b10 < 65536 ? 1 : 2;
                i10++;
                while (true) {
                    i12 = i13;
                    if (i10 < length && (b8 = bArr[i10]) >= 0) {
                        i10++;
                        i13 = i12 + 1;
                        if (i12 == 64) {
                            break loop0;
                        }
                        if ((b8 != 10 && b8 != 13 && ((b8 >= 0 && b8 < 32) || (127 <= b8 && b8 < 160))) || b8 == 65533) {
                            break loop0;
                        }
                        i11 += b8 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b10 >> 5) == -2) {
                int i14 = i10 + 1;
                if (length > i14) {
                    byte b11 = bArr[i14];
                    if ((b11 & 192) == 128) {
                        int i15 = (b11 ^ 3968) ^ (b10 << 6);
                        if (i15 >= 128) {
                            i = i12 + 1;
                            if (i12 == 64) {
                                break;
                            }
                            if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                break;
                            }
                            i11 += i15 < 65536 ? 1 : 2;
                            i10 += 2;
                            i12 = i;
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if ((b10 >> 4) == -2) {
                int i16 = i10 + 2;
                if (length > i16) {
                    byte b12 = bArr[i10 + 1];
                    if ((b12 & 192) == 128) {
                        byte b13 = bArr[i16];
                        if ((b13 & 192) == 128) {
                            int i17 = ((b13 ^ (-123008)) ^ (b12 << 6)) ^ (b10 << 12);
                            if (i17 < 2048) {
                                if (i12 != 64) {
                                    break;
                                }
                            } else if (55296 > i17 || i17 >= 57344) {
                                i = i12 + 1;
                                if (i12 == 64) {
                                    break;
                                }
                                if ((i17 != 10 && i17 != 13 && ((i17 >= 0 && i17 < 32) || (127 <= i17 && i17 < 160))) || i17 == 65533) {
                                    break;
                                }
                                i11 += i17 < 65536 ? 1 : 2;
                                i10 += 3;
                                i12 = i;
                            } else if (i12 != 64) {
                                break;
                            }
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if ((b10 >> 3) == -2) {
                int i18 = i10 + 3;
                if (length > i18) {
                    byte b14 = bArr[i10 + 1];
                    if ((b14 & 192) == 128) {
                        byte b15 = bArr[i10 + 2];
                        if ((b15 & 192) == 128) {
                            byte b16 = bArr[i18];
                            if ((b16 & 192) == 128) {
                                int i19 = (((b16 ^ 3678080) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b10 << 18);
                                if (i19 > 1114111) {
                                    if (i12 != 64) {
                                        break;
                                    }
                                } else if (55296 > i19 || i19 >= 57344) {
                                    if (i19 >= 65536) {
                                        i = i12 + 1;
                                        if (i12 == 64) {
                                            break;
                                        }
                                        if ((i19 != 10 && i19 != 13 && ((i19 >= 0 && i19 < 32) || (127 <= i19 && i19 < 160))) || i19 == 65533) {
                                            break;
                                        }
                                        i11 += i19 < 65536 ? 1 : 2;
                                        i10 += 4;
                                        i12 = i;
                                    } else if (i12 != 64) {
                                        break;
                                    }
                                } else if (i12 != 64) {
                                    break;
                                }
                            } else if (i12 != 64) {
                                break;
                            }
                        } else if (i12 != 64) {
                            break;
                        }
                    } else if (i12 != 64) {
                        break;
                    }
                } else if (i12 != 64) {
                    break;
                }
            } else if (i12 != 64) {
                break;
            }
        }
        i11 = -1;
        if (i11 != -1) {
            String strJ = j();
            String strSubstring = strJ.substring(0, i11);
            ge.i.d(strSubstring, "substring(...)");
            String strX = ne.o.X(ne.o.X(ne.o.X(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i11 >= strJ.length()) {
                return "[text=" + strX + ']';
            }
            return "[size=" + bArr.length + " text=" + strX + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + b() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 <= bArr.length) {
            sb.append((64 == bArr.length ? this : new h(sd.i.j(bArr, 0, 64))).b());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }
}

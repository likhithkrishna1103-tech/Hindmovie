package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h5 implements Cloneable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i5 f2469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i5 f2470w;

    public h5(i5 i5Var) {
        this.f2469v = i5Var;
        if (i5Var.e()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f2470w = (i5) i5Var.o(4);
    }

    public static void a(int i, List list) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String string = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i) {
                throw new NullPointerException(string);
            }
            list.remove(size2);
        }
    }

    public final void b() {
        if (this.f2470w.e()) {
            return;
        }
        i5 i5Var = (i5) this.f2469v.o(4);
        g6.f2460c.a(i5Var.getClass()).d(i5Var, this.f2470w);
        this.f2470w = i5Var;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h5 clone() {
        h5 h5Var = (h5) this.f2469v.o(5);
        h5Var.f2470w = d();
        return h5Var;
    }

    public final i5 d() {
        if (!this.f2470w.e()) {
            return this.f2470w;
        }
        this.f2470w.g();
        return this.f2470w;
    }

    public final i5 e() {
        i5 i5VarD = d();
        i5VarD.getClass();
        boolean zH = true;
        byte bByteValue = ((Byte) i5VarD.o(1)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                zH = false;
            } else {
                zH = g6.f2460c.a(i5VarD.getClass()).h(i5VarD);
                i5VarD.o(2);
            }
        }
        if (zH) {
            return i5VarD;
        }
        throw new a9.l("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final void f(i5 i5Var) {
        i5 i5Var2 = this.f2469v;
        if (i5Var2.equals(i5Var)) {
            return;
        }
        if (!this.f2470w.e()) {
            i5 i5Var3 = (i5) i5Var2.o(4);
            g6.f2460c.a(i5Var3.getClass()).d(i5Var3, this.f2470w);
            this.f2470w = i5Var3;
        }
        i5 i5Var4 = this.f2470w;
        g6.f2460c.a(i5Var4.getClass()).d(i5Var4, i5Var);
    }

    public final void g(byte[] bArr, int i, c5 c5Var) {
        if (!this.f2470w.e()) {
            i5 i5Var = (i5) this.f2469v.o(4);
            g6.f2460c.a(i5Var.getClass()).d(i5Var, this.f2470w);
            this.f2470w = i5Var;
        }
        try {
            j6 j6VarA = g6.f2460c.a(this.f2470w.getClass());
            i5 i5Var2 = this.f2470w;
            x4 x4Var = new x4();
            c5Var.getClass();
            j6VarA.c(i5Var2, bArr, 0, i, x4Var);
        } catch (r5 e9) {
            throw e9;
        } catch (IOException e10) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e10);
        } catch (IndexOutOfBoundsException unused) {
            throw new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}

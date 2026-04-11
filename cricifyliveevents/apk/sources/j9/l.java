package j9;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements f, e, c {
    public int A;
    public Exception B;
    public boolean C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f6693v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f6694w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f6695x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6696y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6697z;

    public l(int i, p pVar) {
        this.f6694w = i;
        this.f6695x = pVar;
    }

    @Override // j9.f
    public final void a(Object obj) {
        synchronized (this.f6693v) {
            this.f6696y++;
            c();
        }
    }

    @Override // j9.c
    public final void b() {
        synchronized (this.f6693v) {
            this.A++;
            this.C = true;
            c();
        }
    }

    public final void c() {
        int i = this.f6696y + this.f6697z + this.A;
        int i10 = this.f6694w;
        if (i == i10) {
            Exception exc = this.B;
            p pVar = this.f6695x;
            if (exc == null) {
                if (this.C) {
                    pVar.o();
                    return;
                } else {
                    pVar.l(null);
                    return;
                }
            }
            int i11 = this.f6697z;
            int length = String.valueOf(i11).length();
            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + length + 8 + 24);
            sb.append(i11);
            sb.append(" out of ");
            sb.append(i10);
            sb.append(" underlying tasks failed");
            pVar.n(new ExecutionException(sb.toString(), this.B));
        }
    }

    @Override // j9.e
    public final void y(Exception exc) {
        synchronized (this.f6693v) {
            this.f6697z++;
            this.B = exc;
            c();
        }
    }
}

package pf;

import c2.o;
import com.bumptech.glide.l;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kf.r;
import kf.u;
import kf.z;
import of.n;
import of.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10292a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10293b;

    public a(kf.b bVar) {
        ge.i.e(bVar, "cookieJar");
        this.f10293b = bVar;
    }

    public static int d(z zVar, int i) {
        String strA = zVar.A.a("Retry-After");
        if (strA == null) {
            strA = null;
        }
        if (strA == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        ge.i.d(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strA).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        ge.i.d(numValueOf, "valueOf(...)");
        return numValueOf.intValue();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v47 of.p, still in use, count: 2, list:
          (r0v47 of.p) from 0x0076: MOVE (r18v0 of.p) = (r0v47 of.p) (LINE:119)
          (r0v47 of.p) from 0x0063: MOVE (r18v3 of.p) = (r0v47 of.p) (LINE:100)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // kf.r
    public final kf.z a(pf.h r34) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pf.a.a(pf.h):kf.z");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c2.o b(kf.z r13, com.bumptech.glide.l r14) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pf.a.b(kf.z, com.bumptech.glide.l):c2.o");
    }

    public boolean c(IOException iOException, n nVar, o oVar) {
        boolean z10 = iOException instanceof rf.a;
        if (!((u) this.f10293b).f7552e) {
            return false;
        }
        if ((!z10 && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException)) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z10) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        l lVar = nVar.L;
        if (lVar == null || !lVar.f2222v) {
            return false;
        }
        of.h hVar = nVar.B;
        ge.i.b(hVar);
        p pVarL = hVar.l();
        l lVar2 = nVar.L;
        return pVarL.a(lVar2 != null ? lVar2.h() : null);
    }

    public a(u uVar) {
        this.f10293b = uVar;
    }
}

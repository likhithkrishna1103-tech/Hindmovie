package ec;

import androidx.lifecycle.j0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ob.d f4647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.b f4648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nd.i f4649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final se.c f4650d = new se.c(false);

    public e(rd.h hVar, ob.d dVar, cc.b bVar, a7.b bVar2, z0.f fVar) {
        this.f4647a = dVar;
        this.f4648b = bVar2;
        this.f4649c = new nd.i(new j0(2, fVar));
    }

    public static String c(String str) {
        Pattern patternCompile = Pattern.compile("/");
        be.h.d(patternCompile, "compile(...)");
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        be.h.d(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final Boolean a() {
        f fVar = b().f4675b;
        if (fVar != null) {
            return fVar.f4651a;
        }
        be.h.i("sessionConfigs");
        throw null;
    }

    public final m b() {
        return (m) this.f4649c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:43:0x00ab, B:45:0x00b7, B:48:0x00c0, B:50:0x0137, B:51:0x0143, B:35:0x0086, B:37:0x0090, B:40:0x0099), top: B:62:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0 A[Catch: all -> 0x0052, TRY_ENTER, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:43:0x00ab, B:45:0x00b7, B:48:0x00c0, B:50:0x0137, B:51:0x0143, B:35:0x0086, B:37:0x0090, B:40:0x0099), top: B:62:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(rd.c r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.e.d(rd.c):java.lang.Object");
    }
}

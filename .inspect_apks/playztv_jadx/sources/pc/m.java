package pc;

import java.io.IOException;
import java.net.ServerSocket;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends ld.k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile m f10334g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10335e;
    public String f;

    public m(String str) throws IOException {
        this.f8156c = new af.a(7);
        this.f = str;
        this.f10335e = l4.a.o(new StringBuilder("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Ad</title>\n    <style>\n        body {\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            margin: 0;\n            background: transparent;\n        }\n    </style>\n</head>\n<body>\n"), this.f, "</body>\n</html>");
        this.f8154a = new ServerSocket();
        this.f8154a.setReuseAddress(true);
        ld.j jVar = new ld.j(this);
        Thread thread = new Thread(jVar);
        this.f8155b = thread;
        thread.setDaemon(false);
        this.f8155b.setName("NanoHttpd Main Listener");
        this.f8155b.start();
        while (!jVar.f8151v && jVar.f8150u == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = jVar.f8150u;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final ld.h e() {
        return ld.k.c(ld.g.f8137w, "text/html", this.f10335e);
    }
}

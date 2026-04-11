package z5;

import f9.s0;
import java.io.IOException;
import java.net.ServerSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends pd.i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile l f15222g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15223e;
    public String f;

    public l(String str) throws IOException {
        this.f10214c = new s0(6);
        this.f = str;
        this.f15223e = q4.a.q(new StringBuilder("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Ad</title>\n    <style>\n        body {\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            margin: 0;\n            background: transparent;\n        }\n    </style>\n</head>\n<body>\n"), this.f, "</body>\n</html>");
        this.f10212a = new ServerSocket();
        this.f10212a.setReuseAddress(true);
        pd.h hVar = new pd.h(this);
        Thread thread = new Thread(hVar);
        this.f10213b = thread;
        thread.setDaemon(false);
        this.f10213b.setName("NanoHttpd Main Listener");
        this.f10213b.start();
        while (!hVar.f10209w && hVar.f10208v == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = hVar.f10208v;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final pd.f e() {
        return pd.i.c(pd.e.f10197x, "text/html", this.f15223e);
    }
}

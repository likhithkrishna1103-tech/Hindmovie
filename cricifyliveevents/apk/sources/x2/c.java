package x2;

import android.os.SystemClock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import l0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f14288a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f14289b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f14290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f14291d;

    public static long a() {
        byte b8;
        SocketTimeoutException socketTimeoutException;
        byte[] bArr;
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            synchronized (f14289b) {
            }
            datagramSocket.setSoTimeout(1000);
            c();
            InetAddress[] allByName = InetAddress.getAllByName("time.android.com");
            int length = allByName.length;
            byte b10 = 0;
            SocketTimeoutException socketTimeoutException2 = null;
            int i = 0;
            int i10 = 0;
            while (i < length) {
                byte[] bArr2 = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr2, 48, allByName[i], 123);
                bArr2[b10] = 27;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jCurrentTimeMillis == 0) {
                    Arrays.fill(bArr2, 40, 48, b10);
                    b8 = b10;
                    socketTimeoutException = socketTimeoutException2;
                    bArr = bArr2;
                } else {
                    long j4 = jCurrentTimeMillis / 1000;
                    Long.signum(j4);
                    long j7 = jCurrentTimeMillis - (j4 * 1000);
                    b8 = b10;
                    socketTimeoutException = socketTimeoutException2;
                    long j10 = j4 + 2208988800L;
                    bArr = bArr2;
                    bArr[40] = (byte) (j10 >> 24);
                    bArr[41] = (byte) (j10 >> 16);
                    bArr[42] = (byte) (j10 >> 8);
                    bArr[43] = (byte) j10;
                    long j11 = (j7 * 4294967296L) / 1000;
                    bArr[44] = (byte) (j11 >> 24);
                    bArr[45] = (byte) (j11 >> 16);
                    bArr[46] = (byte) (j11 >> 8);
                    bArr[47] = (byte) (Math.random() * 255.0d);
                }
                datagramSocket.send(datagramPacket);
                byte[] bArr3 = bArr;
                try {
                    datagramSocket.receive(new DatagramPacket(bArr3, 48));
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j12 = (jElapsedRealtime2 - jElapsedRealtime) + jCurrentTimeMillis;
                    byte b11 = bArr3[b8];
                    int i11 = bArr3[1] & 255;
                    long jE = e(24, bArr3);
                    long jE2 = e(32, bArr3);
                    long jE3 = e(40, bArr3);
                    b((byte) ((b11 >> 6) & 3), (byte) (b11 & 7), i11, jE3);
                    long j13 = (j12 + (((jE3 - j12) + (jE2 - jE)) / 2)) - jElapsedRealtime2;
                    datagramSocket.close();
                    return j13;
                } catch (SocketTimeoutException e9) {
                    if (socketTimeoutException == null) {
                        socketTimeoutException2 = e9;
                    } else {
                        SocketTimeoutException socketTimeoutException3 = socketTimeoutException;
                        socketTimeoutException3.addSuppressed(e9);
                        socketTimeoutException2 = socketTimeoutException3;
                    }
                    int i12 = i10 + 1;
                    if (i10 >= 10) {
                        socketTimeoutException2.getClass();
                        throw socketTimeoutException2;
                    }
                    i++;
                    i10 = i12;
                    b10 = b8;
                }
            }
            socketTimeoutException2.getClass();
            throw socketTimeoutException2;
        } finally {
        }
    }

    public static void b(byte b8, byte b10, int i, long j4) throws IOException {
        if (b8 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b10 != 4 && b10 != 5) {
            throw new IOException(e.g(b10, "SNTP: Untrusted mode: "));
        }
        if (i == 0 || i > 15) {
            throw new IOException(e.g(i, "SNTP: Untrusted stratum: "));
        }
        if (j4 == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static void c() {
        synchronized (f14289b) {
        }
    }

    public static long d(int i, byte[] bArr) {
        int i10 = bArr[i];
        int i11 = bArr[i + 1];
        int i12 = bArr[i + 2];
        int i13 = bArr[i + 3];
        if ((i10 & 128) == 128) {
            i10 = (i10 & 127) + 128;
        }
        if ((i11 & 128) == 128) {
            i11 = (i11 & 127) + 128;
        }
        if ((i12 & 128) == 128) {
            i12 = (i12 & 127) + 128;
        }
        if ((i13 & 128) == 128) {
            i13 = (i13 & 127) + 128;
        }
        return (((long) i10) << 24) + (((long) i11) << 16) + (((long) i12) << 8) + ((long) i13);
    }

    public static long e(int i, byte[] bArr) {
        long jD = d(i, bArr);
        long jD2 = d(i + 4, bArr);
        if (jD == 0 && jD2 == 0) {
            return 0L;
        }
        return ((jD2 * 1000) / 4294967296L) + ((jD - 2208988800L) * 1000);
    }
}

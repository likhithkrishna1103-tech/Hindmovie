package h4;

import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends MediaSession.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f5839a;

    public q(r rVar) {
        this.f5839a = rVar;
    }

    public static void b(t tVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        MediaSession mediaSession = tVar.f5847a;
        String str = null;
        if (i >= 24) {
            try {
                str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
            } catch (Exception e10) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e10);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "android.media.session.MediaController";
        }
        tVar.d(new b0(-1, -1, str));
    }

    public final t a() {
        t tVar;
        synchronized (this.f5839a.f5840a) {
            tVar = (t) this.f5839a.f5843d.get();
        }
        if (tVar == null || this.f5839a != tVar.b()) {
            return null;
        }
        return tVar;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        i5.d dVar;
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        try {
            if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                if (resultReceiver != null) {
                    Bundle bundle2 = new Bundle();
                    y yVar = tVarA.f5849c;
                    h hVarA = yVar.a();
                    bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", hVarA == null ? null : hVarA.asBinder());
                    synchronized (yVar.f5862u) {
                        dVar = yVar.f5865x;
                    }
                    if (dVar != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("a", new ParcelImpl(dVar));
                        bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                    }
                    resultReceiver.send(0, bundle2);
                }
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                if (bundle != null) {
                    this.f5839a.b((n) t1.i(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), n.CREATOR));
                }
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                if (bundle != null) {
                    this.f5839a.c((n) t1.i(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), n.CREATOR), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                }
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                if (bundle != null) {
                    this.f5839a.q((n) t1.i(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), n.CREATOR));
                }
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                List list = tVarA.f5853h;
                if (list != null && bundle != null) {
                    int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    w wVar = (i < 0 || i >= list.size()) ? null : (w) list.get(i);
                    if (wVar != null) {
                        this.f5839a.q(wVar.f5858u);
                    }
                }
            } else {
                this.f5839a.d(str, bundle, resultReceiver);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCustomAction(String str, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        try {
            boolean zEquals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
            r rVar = this.f5839a;
            if (zEquals) {
                if (bundle != null) {
                    Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    z.Z(bundle2);
                    rVar.l(uri, bundle2);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                rVar.m();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                if (bundle != null) {
                    String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                    Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    z.Z(bundle3);
                    rVar.n(string, bundle3);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                if (bundle != null) {
                    String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                    Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    z.Z(bundle4);
                    rVar.o(string2, bundle4);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                if (bundle != null) {
                    Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    z.Z(bundle5);
                    rVar.p(uri2, bundle5);
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                if (bundle != null) {
                    bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                if (bundle != null) {
                    rVar.w(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                if (bundle != null) {
                    rVar.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                if (bundle != null) {
                    i0 i0Var = (i0) t1.i(bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), i0.CREATOR);
                    z.Z(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                    rVar.v(i0Var);
                }
            } else if (!str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                rVar.e(str, bundle);
            } else if (bundle != null) {
                rVar.t(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
        }
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onFastForward() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.f();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        t tVarA = a();
        if (tVarA == null) {
            return false;
        }
        b(tVarA);
        boolean zG = this.f5839a.g(intent);
        tVarA.d(null);
        return zG || super.onMediaButtonEvent(intent);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPause() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.h();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlay() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.i();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.j(str, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.k(str, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.l(uri, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepare() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.m();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.n(str, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.o(str, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        z.Z(bundle);
        b(tVarA);
        this.f5839a.p(uri, bundle);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onRewind() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.r();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSeekTo(long j5) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.s(j5);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetPlaybackSpeed(float f) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.t(f);
        tVarA.d(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // android.media.session.MediaSession.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSetRating(android.media.Rating r7) {
        /*
            r6 = this;
            h4.t r0 = r6.a()
            if (r0 != 0) goto L7
            return
        L7:
            b(r0)
            r1 = 0
            if (r7 == 0) goto L1d
            int r2 = r7.getRatingStyle()
            boolean r3 = r7.isRated()
            if (r3 == 0) goto L4e
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            switch(r2) {
                case 1: goto L40;
                case 2: goto L31;
                case 3: goto L28;
                case 4: goto L28;
                case 5: goto L28;
                case 6: goto L1f;
                default: goto L1d;
            }
        L1d:
            r2 = r1
            goto L60
        L1f:
            float r2 = r7.getPercentRating()
            h4.i0 r2 = h4.i0.c(r2)
            goto L5b
        L28:
            float r3 = r7.getStarRating()
            h4.i0 r2 = h4.i0.d(r2, r3)
            goto L5b
        L31:
            boolean r2 = r7.isThumbUp()
            h4.i0 r5 = new h4.i0
            if (r2 == 0) goto L3a
            r3 = r4
        L3a:
            r2 = 2
            r5.<init>(r2, r3)
        L3e:
            r2 = r5
            goto L5b
        L40:
            boolean r2 = r7.hasHeart()
            h4.i0 r5 = new h4.i0
            if (r2 == 0) goto L49
            r3 = r4
        L49:
            r2 = 1
            r5.<init>(r2, r3)
            goto L3e
        L4e:
            switch(r2) {
                case 1: goto L53;
                case 2: goto L53;
                case 3: goto L53;
                case 4: goto L53;
                case 5: goto L53;
                case 6: goto L53;
                default: goto L51;
            }
        L51:
            r2 = r1
            goto L5b
        L53:
            h4.i0 r3 = new h4.i0
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3.<init>(r2, r4)
            r2 = r3
        L5b:
            r2.getClass()
            r2.f5820w = r7
        L60:
            h4.r r7 = r6.f5839a
            r7.u(r2)
            r0.d(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.q.onSetRating(android.media.Rating):void");
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToNext() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.y();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToPrevious() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.z();
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToQueueItem(long j5) {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.A(j5);
        tVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onStop() {
        t tVarA = a();
        if (tVarA == null) {
            return;
        }
        b(tVarA);
        this.f5839a.B();
        tVarA.d(null);
    }
}

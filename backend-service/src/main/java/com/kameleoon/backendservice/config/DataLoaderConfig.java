package com.kameleoon.backendservice.config;

import com.kameleoon.backendservice.entity.Quote;
import com.kameleoon.backendservice.entity.User;
import com.kameleoon.backendservice.entity.Voting;
import com.kameleoon.backendservice.repository.QuoteRepository;
import com.kameleoon.backendservice.repository.UserRepository;
import com.kameleoon.backendservice.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoaderConfig {

    private static final byte UPVOTE = 1;

    private static final byte DOWNVOTE = -1;

    private final UserRepository userRepository;

    private final QuoteRepository quoteRepository;

    private final VotingRepository votingRepository;

    @Autowired
    public DataLoaderConfig(UserRepository userRepository, QuoteRepository quoteRepository, VotingRepository votingRepository) {
        this.userRepository = userRepository;
        this.quoteRepository = quoteRepository;
        this.votingRepository = votingRepository;
    }


    @Bean
    public ApplicationRunner dataLoader() {
        return args -> {
            User aganDalton = new User(null, "Agan Dalton", "agan.dalton@gmail.com", "Pa$$word", null);
            User barnesBlake = new User(null, "Barnes Blake", "barnes.blake@gmail.com", "Pa$$word", null);
            User castoRyan = new User(null, "Casto Ryan", "casto.ryan@gmail.com", "Pa$$word", null);
            User durenPaige = new User(null, "Duren Paige", "duren.paige@gmail.com", "Pa$$word", null);
            User frankHailee = new User(null, "Frank Hailee", "frank.hailee@gmail.com", "Pa$$word", null);
            userRepository.saveAll(Arrays.asList(aganDalton, barnesBlake, castoRyan, durenPaige, frankHailee));

            Quote aganDaltonFromOscarWilde = new Quote(null, "Be yourself; everyone else is already taken.", null, aganDalton, null);
            Quote aganDaltonFromMarilynMonroe = new Quote(null, "I'm selfish, impatient and a little insecure...", null, aganDalton, null);
            Quote aganDaltonFromAlbertEinstein = new Quote(null, "Two things are infinite: ...", null, aganDalton, null);
            quoteRepository.saveAll(Arrays.asList(aganDaltonFromOscarWilde, aganDaltonFromMarilynMonroe, aganDaltonFromAlbertEinstein));
            Quote barnesBlakeFromFrankZappa = new Quote(null, "So many books, so little time.", null, barnesBlake, null);
            Quote barnesBlakeFromMarcusTulliusCicero = new Quote(null, "A room without books is like a body without a soul.", null, barnesBlake, null);
            quoteRepository.saveAll(Arrays.asList(barnesBlakeFromFrankZappa, barnesBlakeFromMarcusTulliusCicero));
            Quote castoRyanFromBernardBaruch = new Quote(null, "Be who you are and say what you feel ...", null, castoRyan, null);
            Quote castoRyanFromWilliamPurkey = new Quote(null, "You've gotta dance like there's nobody watching, ...", null, castoRyan, null);
            quoteRepository.saveAll(Arrays.asList(castoRyanFromBernardBaruch, castoRyanFromWilliamPurkey));
            Quote durenPaigeFromDrSeuss = new Quote(null, "You know you're in love when you can't fall asleep ...", null, durenPaige, null);
            Quote durenPaigeFromMaeWest = new Quote(null, "You only live once, but if you do it right, once is enough.", null, durenPaige, null);
            Quote durenPaigeFromMahatmaGandhi = new Quote(null, "Be the change that you wish to see in the world.", null, durenPaige, null);
            Quote durenPaigeFromRobertFrost = new Quote(null, "In three words I can sum up everything I've learned about life: ...", null, durenPaige, null);
            quoteRepository.saveAll(Arrays.asList(durenPaigeFromDrSeuss, durenPaigeFromMaeWest, durenPaigeFromMahatmaGandhi, durenPaigeFromRobertFrost));
            Quote frankHaileeFromAlbertCamus = new Quote(null, "Don’t walk in front of me… I may not follow ...", null, frankHailee, null);
            quoteRepository.saveAll(Arrays.asList(frankHaileeFromAlbertCamus));

            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, barnesBlake, aganDaltonFromOscarWilde),
                    new Voting(UPVOTE, castoRyan, aganDaltonFromOscarWilde),
                    new Voting(DOWNVOTE, durenPaige, aganDaltonFromOscarWilde),
                    new Voting(UPVOTE, frankHailee, aganDaltonFromOscarWilde)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, barnesBlake, aganDaltonFromMarilynMonroe),
                    new Voting(UPVOTE, castoRyan, aganDaltonFromMarilynMonroe),
                    new Voting(DOWNVOTE, durenPaige, aganDaltonFromMarilynMonroe)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, barnesBlake, aganDaltonFromAlbertEinstein),
                    new Voting(UPVOTE, castoRyan, aganDaltonFromAlbertEinstein)
            ));

            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, aganDalton, barnesBlakeFromFrankZappa),
                    new Voting(UPVOTE, castoRyan, barnesBlakeFromFrankZappa),
                    new Voting(UPVOTE, durenPaige, barnesBlakeFromFrankZappa),
                    new Voting(UPVOTE, frankHailee, barnesBlakeFromFrankZappa)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(DOWNVOTE, aganDalton, barnesBlakeFromMarcusTulliusCicero),
                    new Voting(DOWNVOTE, frankHailee, barnesBlakeFromMarcusTulliusCicero)
            ));

            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, aganDalton, castoRyanFromBernardBaruch),
                    new Voting(UPVOTE, barnesBlake, castoRyanFromBernardBaruch),
                    new Voting(UPVOTE, durenPaige, castoRyanFromBernardBaruch),
                    new Voting(DOWNVOTE, frankHailee, castoRyanFromBernardBaruch)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, barnesBlake, castoRyanFromWilliamPurkey),
                    new Voting(UPVOTE, durenPaige, castoRyanFromWilliamPurkey),
                    new Voting(DOWNVOTE, frankHailee, castoRyanFromWilliamPurkey)
            ));

            votingRepository.saveAll(Arrays.asList(
                    new Voting(DOWNVOTE, aganDalton, durenPaigeFromDrSeuss),
                    new Voting(UPVOTE, barnesBlake, durenPaigeFromDrSeuss),
                    new Voting(DOWNVOTE, castoRyan, durenPaigeFromDrSeuss),
                    new Voting(DOWNVOTE, frankHailee, durenPaigeFromDrSeuss)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(DOWNVOTE, frankHailee, durenPaigeFromMaeWest)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(UPVOTE, aganDalton, durenPaigeFromMahatmaGandhi),
                    new Voting(UPVOTE, barnesBlake, durenPaigeFromMahatmaGandhi)
            ));
            votingRepository.saveAll(Arrays.asList(
                    new Voting(DOWNVOTE, aganDalton, durenPaigeFromRobertFrost)
            ));

            votingRepository.saveAll(Arrays.asList(
                    new Voting(DOWNVOTE, aganDalton, frankHaileeFromAlbertCamus),
                    new Voting(UPVOTE, barnesBlake, frankHaileeFromAlbertCamus),
                    new Voting(UPVOTE, castoRyan, frankHaileeFromAlbertCamus),
                    new Voting(DOWNVOTE, durenPaige, frankHaileeFromAlbertCamus)
            ));
        };
    }
}

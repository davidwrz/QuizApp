package au.davidwrz.quizapp.modules.external.competition.infrastructure.db;

import au.davidwrz.quizapp.modules.external.competition.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

interface CompetitionRepository extends JpaRepository<Competition, Integer> {
}
